package ru.runanddone.admin.contragents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.contragents.model.ContragentOrdertype;
import ru.runanddone.admin.contragents.model.ContragentOrdertypeKey;

@Repository
public interface ContragentOrdertypeRepository extends JpaRepository<ContragentOrdertype, ContragentOrdertypeKey> {

}
