package com.backend_inventario.inventario.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend_inventario.inventario.entity.LaboratoryItem;
import com.backend_inventario.inventario.entity.Loan;
import com.backend_inventario.inventario.entity.dto.ListLoanByItemDto;
import com.backend_inventario.inventario.entity.dto.LoanSumaryViewDto;
import com.backend_inventario.inventario.repository.LaboratoryItemRepository;
import com.backend_inventario.inventario.repository.LoanRepository;
import com.backend_inventario.inventario.repository.LoanSumaryViewRepository;
import com.backend_inventario.inventario.util.ResourceNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanSumaryViewRepository loanSumaryViewRepository;

    @Autowired
    private LaboratoryItemRepository laboratoryItemRepository;

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
    public Loan createLoan(Loan loan, List<Long> laboratoryItemIds) {
        List<LaboratoryItem> items = laboratoryItemRepository.findAllById(laboratoryItemIds);
        loan.setLaboratoryItems(new HashSet<>(items));
        return loanRepository.save(loan);
    }

    public List<LoanSumaryViewDto> getLoansDinamic(){
        return loanSumaryViewRepository.findAll();
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

    public List<ListLoanByItemDto> getLoanIntemHistory(Long itemId) {
        String jpql = "SELECT new com.backend_inventario.inventario.entity.dto.ListLoanByItemDto(l.id, l.loanDate, l.expectedReturnDate, l.returnDate, l.status, l.userLoan.name) " +
                      "FROM Loan l " +
                      "JOIN l.laboratoryItems li " +
                      "WHERE li.id = :itemId";

        TypedQuery<ListLoanByItemDto> query = entityManager.createQuery(jpql, ListLoanByItemDto.class);
        query.setParameter("itemId", itemId);

        return query.getResultList();
    }
}
