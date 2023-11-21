package Model;

public class Estudante {
  
  private String nomeCompleto;

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


  public Estudante(String nomeCompleto, int idade, String email, String endereco,
      String usuario, String senha, String curso, boolean ativo) {

    setNomeCompleto(nomeCompleto);
    setIdade(idade);
    setEmail(email);
    setEndereco(endereco);
    setCep(cep);
    setTelefone(telefone);
    setUsuario(usuario);
    setSenha(senha);
    setCurso(curso);
    setObservacoes(observacoes);
    setAtivo(ativo);
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
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
  
  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }
}
