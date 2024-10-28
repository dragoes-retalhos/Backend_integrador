package com.backend_inventario.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend_inventario.inventario.entity.Loan;
import com.backend_inventario.inventario.entity.UserLoan;
import com.backend_inventario.inventario.repository.LoanRepository;
import com.backend_inventario.inventario.util.ResourceNotFoundException;

import jakarta.persistence.EntityManager;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;
/* 
    @Autowired
    private LaboratoryItemRepository laboratoryItemRepository;
*/
    @Autowired
    private EntityManager entityManager;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(Long loanId) {
        return loanRepository.findById(loanId)
            .orElseThrow(() -> new ResourceNotFoundException("Empréstimo não encontrado com o ID: " + loanId));
    }

    @Transactional
    public Loan createLoan(Loan loan) {
       
        if (loan.getUserLoan() != null && loan.getUserLoan().getId() > 0) {
            loan.setUserLoan(entityManager.getReference(UserLoan.class, loan.getUserLoan().getId()));
        }

        return loanRepository.save(loan);
    }

  /*   
    @Transactional
    public Loan updateLoan(Long loanId, LoanDTO loanDTO) {
        Loan loan = loanRepository.findById(loanId)
            .orElseThrow(() -> new ResourceNotFoundException("Empréstimo não encontrado com o ID: " + loanId));

        updateFields(loan, loanDTO);
        return loanRepository.save(loan);
    }
 
    private void validateLaboratoryItemExists(Long laboratoryItemId) {
        if (!laboratoryItemRepository.existsById(laboratoryItemId)) {
            throw new ResourceNotFoundException("Item não encontrado com ID: " + laboratoryItemId);
        }
    }

    private void updateFields(Loan loan, LoanDTO dto) {
        Optional.ofNullable(dto.getStatus()) // Supondo que LoanDTO tenha um status
                .ifPresent(loan::setStatus);
        
        Optional.ofNullable(dto.getDueDate()) // Supondo que LoanDTO tenha uma data de devolução
                .ifPresent(loan::setDueDate);
        
        Optional.ofNullable(dto.getDescription()) // Supondo que LoanDTO tenha uma descrição
                .ifPresent(loan::setDescription);
    }*/
}
