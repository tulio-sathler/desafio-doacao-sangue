package com.doacao.sague.model;

import com.doacao.sague.model.enums.BloodTypeEnum;
import com.doacao.sague.model.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "ID_PESSOA"))
public class Person extends BaseEntity{

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, length = 11, unique = true)
	private String cpf;

	@Column(nullable = false, length = 10, unique = true)
	private String rg;

	@Column(nullable = false)
	private Date dataNascimento;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private GenderEnum sexo;

	@Column(nullable = false)
	private String nomeMae;

	@Column(nullable = false)
	private String nomePai;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false, length = 20)
	private String cep;

	@Column(nullable = false, length = 100)
	private String endereco;

	@Column(nullable = false)
	private Integer numero;

	@Column(nullable = false, length = 50)
	private String bairro;

	@Column(nullable = false, length = 50)
	private String cidade;

	@Column(nullable = false, length = 2)
	private String estado;

	@Column(length = 11)
	private String telefoneFixo;

	@Column(nullable = false, length = 11)
	private String celular;

	@Column(nullable = false)
	private Double altura;

	@Column(nullable = false)
	private Double peso;

	@Column(nullable = false, length = 3)
	@Enumerated(EnumType.STRING)
	private BloodTypeEnum tipoSanguineo;

}
