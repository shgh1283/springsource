package com.example.mart.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.example.mart.entity.item.Item;
import com.example.mart.entity.item.Member;
import com.example.mart.entity.item.Order;
import com.example.mart.entity.item.QItem;
import com.example.mart.entity.item.QMember;
import com.example.mart.entity.item.QOrder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;

public class QueryDslOrderRopositoryImpl extends QuerydslRepositorySupport implements QueryDslOrderRopository {

    public QueryDslOrderRopositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<Member> members() {
        // select *from member where name = 'user1' order by name desc
        QMember qMember = QMember.member;
        JPQLQuery<Member> query = from(qMember);
        query.where(qMember.name.eq("user1")).orderBy(qMember.name.desc());
        JPQLQuery<Member> tuple = query.select(qMember);
        System.out.println(tuple);

        return tuple.fetch();
    }

    @Override
    public List<Item> items() {
        QItem item = QItem.item;

        JPQLQuery<Item> tuple = from(item).where(item.name.eq("아파트").and(item.price.gt(10000))
                .select(item));

        return tuple.fetch();
    }

    @Override
    public List<Object[]> joinTest() {
        QMember qMember = QMember.member;
        QOrder qOrder = QOrder.order;

        JPQLQuery<Tuple> tuple = from(qOrder).join(qMember).on(qOrder.member.eq(qMember)).select(qOrder, qMember);

        List<Tuple> result = tuple.fetch();

        List<Object[]> list = result.stream().map(t -> t.toArray()).collect(Collectors.toList());

        return list;

    }

}
