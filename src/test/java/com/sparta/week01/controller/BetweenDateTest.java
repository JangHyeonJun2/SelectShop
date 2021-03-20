package com.sparta.week01.controller;

import com.sparta.week01.domain.Memo;
import com.sparta.week01.domain.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BetweenDateTest {
    @Autowired
    private MemoRepository memoRepository;
    @Test
    public void findBetweenDate() {
        Memo memo = new Memo("me","hihi");

        System.out.println("first memo "+memo.getModifiedAt()+ "," + memo.getUsername()+" , "+ memo.getContents());
        //출력 : first memo 2021-03-19T19:58:21.704,me , hihi

        memoRepository.save(memo);
        Memo storedMemo = memoRepository.findById(memo.getId()).orElseThrow(() -> new IllegalArgumentException("아이디 없음"));

        System.out.println("second memo " + storedMemo.getModifiedAt()+ "," + memo.getUsername()+" , "+ memo.getContents());
        //출력 : second memo 2021-03-20T19:58:21.708,me , hihi

        LocalDateTime startDatetime = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(0,0,0));//어제
        LocalDateTime endDatetime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,59,59));
        System.out.println(startDatetime + " ," + endDatetime);
        List<Memo> memoList = memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(startDatetime, endDatetime);
        assertThat(memoList.size()).isEqualTo(1);
    }
}
