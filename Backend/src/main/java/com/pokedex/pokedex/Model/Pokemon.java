package com.pokedex.pokedex.Model;
import jakarta.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private String nombre;
    private String tipo;
    private int hp;
    private int ataque;
    private int defensa;

    // Cambiado de LONGTEXT a TEXT para compatibilidad con PostgreSQL
    @Column(columnDefinition = "TEXT")
    private String imagen;

    public Pokemon() {
    }

    public Pokemon(Long id, int numero, String nombre, String tipo, int hp, int ataque, int defensa, String imagen) {
        this.id = id;
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = tipo;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.imagen = imagen;
    }

    // ... (el resto de tus getters y setters se mantienen igual)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public int getDefensa() { return defensa; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
}