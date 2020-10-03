package istic.dao;

import istic.services.Card;

public class CardDao extends AbstractJpaDao<Long, Card>{

    public CardDao() {
        super(Card.class);
    }
}