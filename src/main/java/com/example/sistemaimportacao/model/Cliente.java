package com.example.sistemaimportacao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "clientes")
@Table(name = "clientes")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cliente {

    @Id
    private Long id;
    private String nome;
    private Integer idade;
    private String email;
    private String telefone;
    private String endereco;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "saldo_devedor")
    private Double saldoDevedor;
    private Integer status;

    public Cliente(String[] array) throws ParseException {
        this.id = Long.parseLong(array[0]);
        this.nome = array[1];
        this.idade = Integer.parseInt(array[2]);
        this.email = array[3];
        this.telefone = array[4];
        this.endereco = array[5];
        this.dataNascimento = setDataNascimento(array[6]);
        this.saldoDevedor = Double.parseDouble(array[7]);
        this.status = array[8].equals("Ativo") ? 1 : 0;
    }

    private Date setDataNascimento(String dataString) throws ParseException {
        if (dataString == null || dataString.isEmpty()) {
            throw new IllegalArgumentException("Data de nascimento não informada");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            return sdf.parse(dataString);
        } catch (ParseException e) {
            throw new ParseException("Data inválida: " + dataString, e.getErrorOffset());
        }
    }

}
