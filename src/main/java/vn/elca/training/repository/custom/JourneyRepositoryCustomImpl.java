package vn.elca.training.repository.custom;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.elca.training.model.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class JourneyRepositoryCustomImpl implements JourneyRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<Journey> findBySearchParams(Map<String, String> searchParams, Pageable pageable, Integer offset) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        BooleanBuilder builder = new BooleanBuilder();
        Path<String> orderBy = Expressions.path(String.class, QJourney.journey, "startDate");
        OrderSpecifier orderQuery = new OrderSpecifier(Order.ASC, orderBy );

        for (var entry : searchParams.entrySet()) {
            String key = entry.getKey();
            String expressionKey = expressionOptions(key, entry.getValue()).get(key).get("key").toString();
            String expressionOperator = expressionOptions(key, entry.getValue()).get(key).get("operator").toString();
            Path<QJourney> journey = Expressions.path(QJourney.class, "journey");

            Object expressionValue = expressionOptions(key, entry.getValue()).get(key).get("value");
            Path<String> searchBy = Expressions.path(String.class, journey, expressionKey);

            if (expressionKey.contains(",")) {
                String[] keys = expressionKey.split(",");
                for (String eachKey : keys) {
                    searchBy = Expressions.path(String.class, journey, eachKey);
                    // builder.or(Expressions.predicate(Ops.valueOf(expressionOperator), searchBy, Expressions.constant(expressionValue)));
                    builder.or(Expressions.predicate(Ops.valueOf(expressionOperator), Expressions.stringTemplate("lower({0})", searchBy), Expressions.constant(expressionValue)));
                }
            } else {
                builder.and(Expressions.predicate(Ops.valueOf(expressionOperator), searchBy, Expressions.constant(expressionValue)));
            }
            Sort.Order order = pageable.getSort().stream().findFirst().orElse(null);

            if (order != null) {
                String property = order.getProperty();
                Sort.Direction direction = order.getDirection();


                orderBy = Expressions.path(String.class, journey, property);

                if (direction.isAscending()){
                    orderQuery = new OrderSpecifier<>(Order.ASC, orderBy);
                }
                else{
                    orderQuery = new OrderSpecifier<>(Order.DESC, orderBy);
                }
            }

        }
        JPAQuery<Journey> query = queryFactory
                .select(
                        Projections.bean(
                                Journey.class,
                                QJourney.journey.id,
                                QJourney.journey.name,
                                QJourney.journey.startDate,
                                QJourney.journey.description,
                                QJourney.journey.amount,
                                QJourney.journey.endDate,
                                QJourney.journey.status,
                                QJourney.journey.currency,
                                QJourney.journey.country
                        )
                )
                .from(QJourney.journey)
                .where(builder)
                .orderBy(orderQuery)
                .limit(pageable.getPageSize())
                .offset(offset)
                ;

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

    private static Map<String, Map<String, Object>> expressionOptions(String key, String value) {
        Map<String, Map<String, Object>> result = new HashMap<>();

        switch (key) {
            case "status":
                result.put(key, createExpression("EQ", Journey.JourneyStatus.valueOf(value.toUpperCase()), key));
                break;
            case "fromStartDate":
                result.put(key, createExpression("GOE", LocalDate.parse(value), "startDate"));
                break;
            case "fromEndDate":
                result.put(key, createExpression("GOE", LocalDate.parse(value), "endDate"));
                break;
            case "fromAmount":
                result.put(key, createExpression("GOE", new BigDecimal(value), "amount"));
                break;
            case "toStartDate":
                result.put(key, createExpression("LOE", LocalDate.parse(value), "startDate"));
                break;
            case "toEndDate":
                result.put(key, createExpression("LOE", LocalDate.parse(value), "endDate"));
                break;
            case "toAmount":
                result.put(key, createExpression("LOE", new BigDecimal(value), "amount"));
                break;
            case "country":
                result.put(key, createExpression("EQ", value.toUpperCase(), "country.name"));
                break;
            case "currency":
                result.put(key, createExpression("EQ", value.toUpperCase(), "currency.code"));
                break;
            case "name,description":
                result.put(key, createExpression("LIKE", '%' + value.toLowerCase() + '%', key));
                break;
            default:
                break;
        }
        return result;
    }

    private static Map<String, Object> createExpression(String operator, Object value, Object key) {
        Map<String, Object> expression = new HashMap<>();
        expression.put("operator", operator);
        expression.put("value", value);
        expression.put("key", key);
        return expression;
    }

    private static Map<String, Object> convertTypeUpperLower(Object upper, Object lower, String key) {
        if (key.contains("date")) {
            upper = LocalDate.parse(upper.toString());
            lower = LocalDate.parse(lower.toString());
        }

        if ("amount".equals(key)) {
            upper = new BigDecimal(upper.toString());
            lower = new BigDecimal(lower.toString());
        }

        Map<String, Object> result = new HashMap<>();
        result.put("upper", upper);
        result.put("lower", lower);
        return result;
    }


}
