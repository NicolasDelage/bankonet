package com.cesi.banque.entities.repository;

import com.cesi.banque.entities.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationRepository extends CrudRepository<Operation, Integer> {

    @Query(value = "select * from operation o\n" +
            "  left join compte_courant cc on o.numero_compte_credite = cc.numero\n" +
            "  left join compte_courant ccc on o.numero_compte_debite = ccc.numero\n" +
            "  left join compte_epargne ce on o.numero_compte_credite = ce.numero\n" +
            "  left join compte_epargne cee on o.numero_compte_debite = cee.numero\n" +
            "where cc.client_id = :numero OR ce.client_id = :numero OR ccc.client_id = :numero OR cee.client_id = :numero", nativeQuery = true)
    List<Operation> findOpByClientId(@Param("numero") Integer numero);

}