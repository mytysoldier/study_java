package com.myty.soldier.study_java.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.myty.soldier.study_java.db.tables.SampleTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AsyncDbLogic {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Async
    public CompletableFuture<List<SampleTable>> findAllData() {
        log.info("Execute logic : findAllData");
        List<SampleTable> result = jdbcTemplate.query("select * from sample_table", sampleTableRowMapper());
        log.info("Finish execute logic : findAllData");
        return CompletableFuture.completedFuture(result);
    }

    @Async
    public CompletableFuture<List<SampleTable>> findAllDataAfterSleep() throws InterruptedException {
        log.info("Execute logic : findAllDataAfterSleep");
        List<SampleTable> result = jdbcTemplate.query("select * from sample_table", sampleTableRowMapper());
        // 2 minutes sleep
        Thread.sleep(2000);
        log.info("Finish execute logic : findAllDataAfterSleep");
        return CompletableFuture.completedFuture(result);
    }

    private RowMapper<SampleTable> sampleTableRowMapper() {
        return new RowMapper<SampleTable>() {
            @Override
            public SampleTable mapRow(ResultSet rs, int rowNum) throws SQLException {
                SampleTable table = new SampleTable();
                table.setId(rs.getInt("id"));
                table.setText(rs.getString("text"));
                return table;
            }
        };
    }

}
