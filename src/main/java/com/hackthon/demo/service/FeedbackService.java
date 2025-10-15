package com.hackthon.demo.service;

import com.hackthon.demo.entity.Feedback;
import com.hackthon.demo.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    /**
     * Recupera todos los feedbacks de la base de datos.
     * @return una lista de feedbacks.
     */
    public List<Feedback> findAll() {
        // Llama directamente al método findAll() que nos da JpaRepository.
        return feedbackRepository.findAll();
    }

    /**
     * Busca un feedback por su ID.
     * @param id El ID del feedback a buscar.
     * @return un Optional que contiene el feedback si se encuentra, o un Optional vacío si no.
     */
    public Optional<Feedback> findById(Long id) {
        // Llama al método findById() del repositorio.
        // Devuelve un Optional para que el controlador pueda manejar el caso de "no encontrado".
        return feedbackRepository.findById(id);
    }
}