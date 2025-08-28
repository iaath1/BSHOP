package com.BSHOP.store.repositories;

import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.BSHOP.store.models.Size;

@Repository
public class SizeRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public SizeRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Size> getAllSizes() {
        return jdbcTemplate.query("SELECT * FROM sizes", sizeMapper);
    }

    private final RowMapper<Size> sizeMapper = (rs, rowNum) -> {
        Size size = new Size();
        size.setId((rs.getInt("id")));
        size.setName(rs.getString("name"));

        return size;
    };

}
