package pages;

public class Cartpage {
    //Elementos

    @FindBy(css = "inventory_item_name")
    WebElement lbtTituloProduto.getText();

    @FindBy(css = "inventory_item_prace")
    WebElement lbtPrecoProduto.getText();

    @FindBy(css = "inventory_item_quantily")
    WebElement lbtQuantidade.getText();

    public Cartpage(WebDriver driver){
        super(driver);
        PageFactory.initElements(Driver, This);
    }

    //Funções e Métodos

    public String lerTituloProdutoNoCarrinho(){
        Return lbtTituloProduto.getText();
    }
    public String lerPreçoProdutoNoCarrinho(){
        return lerPreçoProduto.getText();
    }
    public String lerQuantidadeDoProdutoNoCarrinho(){
        return lbtQuantidade.getText();
    }
}
