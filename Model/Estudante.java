package Model;

public class Estudante {
  
  private int id;

  private String nome_completo;

  private int idade;

  private String email;

  private String endereco;

  private String cep;

  private String telefone;

  private String usuario;

  private String senha;

  private String curso;

  private String observacoes;

  private boolean ativo;


  public int getId(){
    return id;
  }

  public void setId(int id){
     this.id = id;
  }

  public String getNomeCompleto() {
    return nome_completo;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nome_completo = nomeCompleto;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
  
  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }
  
  public String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }
  
  public boolean isAtivo() {
    return ativo;
  }
  
  public Boolean getAtivo(){
    return ativo;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }

  @Override
  public String toString(){
    return String.format("%d: %s, %s\n", id, nome_completo, idade, email, endereco, cep, telefone, usuario, senha, curso, observacoes, ativo);
  }

  @Override
  public boolean equals(Object obj){
      if (this == obj) {
        return true;
      }

      if (obj == null) {
        return false;
      }

      if (getClass() != obj.getClass()) {
        return false;
      }

      Estudante estudante = (Estudante) obj;
      return id == estudante.id;
  }
}
