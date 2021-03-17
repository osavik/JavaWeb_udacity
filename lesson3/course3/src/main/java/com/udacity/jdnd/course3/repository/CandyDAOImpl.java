package com.udacity.jdnd.course3.repository;

import com.udacity.jdnd.course3.data.CandyData;
import com.udacity.jdnd.course3.data.dao.CandyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CandyDAOImpl implements CandyDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_CANDIES= "SELECT * FROM candy";

    private static final String INSERT_CANDY_DELIVERY =
            "INSERT INTO candy_delivery (candy_id, delivery_id) " +
            "VALUES(:candyId, :deliveryId)";

    private static final String FIND_CANDY_BY_DELIVERY =
            "SELECT c.* FROM candy_delivery AS cd " +
                    "JOIN candy AS c on c.id = cd.candy_id " +
                    "WHERE cd.delivery_id = :deliveryId";

    private static final RowMapper<CandyData> candyDataRowMapper =
            new BeanPropertyRowMapper<>(CandyData.class);

    @Override
    public List<CandyData> getAllCandies() {

        return jdbcTemplate.
                query(SELECT_ALL_CANDIES,
                        new BeanPropertyRowMapper<>(CandyData.class));
    }

    @Override
    public void addToDelivery(Long candyId, Long deliveryId) {

        jdbcTemplate.update(INSERT_CANDY_DELIVERY,
                new MapSqlParameterSource()
                        .addValue("candyId", candyId)
                        .addValue("deliveryId", deliveryId));
    }

    @Override
    public List<CandyData> getAllCandiesForDelivery(Long deliveryId) {
        return jdbcTemplate.query(FIND_CANDY_BY_DELIVERY,
                new MapSqlParameterSource()
                        .addValue("deliveryId", deliveryId),
                candyDataRowMapper);
    }
}
