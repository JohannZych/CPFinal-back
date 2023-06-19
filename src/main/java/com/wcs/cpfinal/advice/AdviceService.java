package com.wcs.cpfinal.advice;

import com.wcs.cpfinal.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdviceService {

    private final AdviceRepository adviceRepository;

    public List<Advice> getAll() {

        return this.adviceRepository.findAllByOrderByIdDesc();
    }

    public Optional<Advice> getById(Long id) {

        return this.adviceRepository.findById(id);
    }

    public Advice add(Advice advice) {

        return this.adviceRepository.save(advice);
    }

    public Advice update(Long id, Advice advice) {
        Advice existingAdvice = this.adviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Advice not found"));
        existingAdvice.setTitle(advice.getTitle());
        existingAdvice.setContent(advice.getContent());
        existingAdvice.setRating(advice.getRating());
        return this.adviceRepository.save(advice);
    }

    public void delete(Long id) {
        this.adviceRepository.deleteById(id);
    }

    public List<Advice> getByUser(Long id) {
        return this.adviceRepository.findByUser(id);
    }
}
