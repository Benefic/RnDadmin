package ru.runanddone.admin.contragents.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class ContragentOrdertypeKey implements Serializable {
    protected String contragentId;

    @Column(columnDefinition = "BIT")
    protected byte ordertypeId;
}
