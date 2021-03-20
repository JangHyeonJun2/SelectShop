package com.sparta.week01.controller;

import com.sparta.week01.domain.Memo;
import com.sparta.week01.domain.MemoRepository;
import com.sparta.week01.models.MemoRequestDto;
import com.sparta.week01.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    public MemoController(MemoRepository memoRepository, MemoService memoService) {
        this.memoRepository = memoRepository;
        this.memoService = memoService;
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
//        List<Memo> memos = memoRepository.findAllByOrderByModifiedAtDesc();
        LocalDateTime startDatetime = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(0,0,0));//어제
        LocalDateTime endDatetime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,59,59));
        List<Memo> memos = memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(startDatetime,endDatetime);
        return memos;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Long findId = memoService.update(id, requestDto);
        return findId;
    }


    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

}
