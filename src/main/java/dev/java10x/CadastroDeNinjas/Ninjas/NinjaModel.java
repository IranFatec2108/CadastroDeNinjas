package dev.java10x.CadastroDeNinjas.Ninjas;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column (unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "img_Url")
    private String imgUrl;

    //@ManyToOne Um ninja pode ter uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreign KEY ou chave-estrangeira
    private MissoesModel missoes;

}