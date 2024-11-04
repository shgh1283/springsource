package com.example.mart.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mart.entity.constant.OrderStatus;
import com.example.mart.entity.item.Item;
import com.example.mart.entity.item.Member;
import com.example.mart.entity.item.Order;
import com.example.mart.entity.item.OrderItem;
import com.example.mart.repository.item.ItemRepository;
import com.example.mart.repository.item.MemberRepository;
import com.example.mart.repository.item.OrderItemRepository;
import com.example.mart.repository.item.OrderRepository;

import jakarta.transaction.Transactional;

@SpringBootTest

public class MartRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private OrderItemRepository orderitemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;

    // c
    @Test
    public void memberInsertTest() {
        memberRepository.save(Member.builder().name("user1").city("서울시").street("187-12").zipcode("15100").build());
        memberRepository.save(Member.builder().name("user2").city("서울시").street("187-12").zipcode("15100").build());
        memberRepository.save(Member.builder().name("user3").city("서울시").street("187-12").zipcode("15100").build());
    }

    @Test
    public void itemInsertTest() {
        itemRepository.save(Item.builder().name("a").price(1000).quantity(1).build());
        itemRepository.save(Item.builder().name("b").price(1234).quantity(2).build());
        itemRepository.save(Item.builder().name("c").price(1234).quantity(3).build());
    }

    @Test
    public void orderInsertTest() {
        //
        Member member = memberRepository.findById(2L).get();
        Item item = itemRepository.findById(1L).get();

        Order order = Order.builder().orderDate(LocalDateTime.now()).status(OrderStatus.ORDER).member(member).build();
        orderRepository.save(order);

        OrderItem orderItem = OrderItem.builder().price(2000).count(2).order(order).item(item).build();
        orderitemRepository.save(orderItem);

        // Item 수량 감소

    }

    // R

    @Test
    public void memberAndItemAndOrderListTest() {
        // 주문 내역 조회

        // orderRepository.findAll().forEach(order -> System.out.println(order));

        // 주문 상세 내역 조회
        orderitemRepository.findAll().forEach(orderItem -> {
            System.out.println(orderItem);
            System.out.println(orderItem.getItem());
            System.out.println(orderItem.getOrder());
        });
    }

    @Test
    public void memberAndItemAndOrderRowTest() {
        // 주문 내역 조회

        // orderRepository.findAll().forEach(order -> System.out.println(order));

        // 주문 상세 내역 조회
        OrderItem orderItem = orderitemRepository.findById(1L).get();

        System.out.println(orderItem);
        System.out.println(orderItem.getItem());
        System.out.println(orderItem.getOrder());

        System.out.println(orderItem.getOrder().getMember());
    }

    // U
    @Test
    public void memberAndItemAndOrderUpdateTest() {

        // 주문자의 주소 변경
        // Member member = Member.builder()
        // .id(1L)
        // .city("서울시")
        // .name("user1")
        // .street("255-12").zipcode("15100").build();
        Member member = memberRepository.findById(1L).get();
        member.setStreet("189-12");

        // save : insert or update
        // 엔티티 매니저가 있어서 현재 entity 가 new 인지 기존 entity 인지 구분이 가능함
        // new : insert 호출 / 기존 entity : update 호출
        // update 는 무조건 전체 컬럼이 수정되는 형태로 작성 됨
        System.out.println(
                memberRepository.save(member));

        // 1 번 주문 상품의 아이템(2번 아이템) 가격 변경

        // 아이템 수량, 가격 변경
        Item item = itemRepository.findById(2L).get();
        item.setPrice(102000);
        itemRepository.save(item);

        OrderItem orderItem = orderitemRepository.findById(1L).get();
        orderItem.setPrice(102000);
        orderitemRepository.save(orderItem);
    }

    // D
    @Test
    public void memberAndItemAndOrderDeleteTest() {

        // 주문 상품 취소
        orderitemRepository.deleteById(1L);
        // 주문 취소
        orderRepository.deleteById(1L);
    }

    // 양방향
    // Order ==> OrderItem 객체 그래프 탐색
    @Transactional
    @Test
    public void testOrderItemList() {
        Order order = orderRepository.findById(2L).get();
        System.out.println(order);

        // Order ==> OrderItem 탐색 시도
        order.getOrderItemsList().forEach(orderItem -> System.out.println(orderItem));
    }

    @Transactional
    @Test
    public void testOrderList() {
        Member member = memberRepository.findById(1L).get();
        System.out.println(member);

        // Order ==> OrderItem 탐색 시도
        member.getOrders().forEach(order -> System.out.println(order));
    }
}
