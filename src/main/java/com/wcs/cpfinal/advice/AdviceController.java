package com.wcs.cpfinal.advice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/advice")
@RequiredArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;

    @GetMapping
    private List<Advice> getAll() {
        return adviceService.getAll();
    }

    @GetMapping("{id}")
    private Optional<Advice> getById(@PathVariable("id") Long id) {
        return adviceService.getById(id);
    }

    @PostMapping("/add")
    private Advice add(@RequestBody Advice advice) {

        return adviceService.add(advice);
    }

    @PutMapping("/update/{id}")
    private Advice update(@PathVariable("id") Long id, @RequestBody Advice advice) {
        return adviceService.update(id, advice);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable("id") Long id) {
        adviceService.delete(id);
    }
}
