package com.example.mart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.example.mart.entity.item.Item;
import com.example.mart.entity.item.Member;
import com.example.mart.entity.item.Order;

public class QueryDslOrderRopositoryImpl extends QuerydslRepositorySupport implements QueryDslOrderRopository {

    public QueryDslOrderRopositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<Member> members() {
        return null;

    }

    @Override
    public List<Item> items() {

        return null;
    }

    @Override
    public List<Object[]> joinTest() {
        return null;

    }

}
