package ru.runanddone.admin.contragents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.contragents.model.Contragent;

@Repository
public interface ContragentRepository extends JpaRepository<Contragent, String> {

}
