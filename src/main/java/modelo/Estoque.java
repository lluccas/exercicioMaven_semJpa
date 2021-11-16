package modelo;

public class Estoque {
	//atributos
	private int id;
	private String marca;
	private String modelo;
	private String cor;
	private String memoriaInterna;
	private String memoriaRam;
	private String cameraTraseira;
	private String cameraFrontal;
	private Double tela;
	private String processador;
	private int quantidade;
	private double preco;
	
	//metodos especiais
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMemoriaInterna() {
		return memoriaInterna;
	}
	public void setMemoriaInterna(String memoriaInterna) {
		this.memoriaInterna = memoriaInterna;
	}
	public String getMemoriaRam() {
		return memoriaRam;
	}
	public void setMemoriaRam(String memoriaRam) {
		this.memoriaRam = memoriaRam;
	}
	public String getCameraTraseira() {
		return cameraTraseira;
	}
	public void setCameraTraseira(String cameraTraseira) {
		this.cameraTraseira = cameraTraseira;
	}
	public String getCameraFrontal() {
		return cameraFrontal;
	}
	public void setCameraFrontal(String cameraFrontal) {
		this.cameraFrontal = cameraFrontal;
	}
	public Double getTela() {
		return tela;
	}
	public void setTela(Double tela) {
		this.tela = tela;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
}
