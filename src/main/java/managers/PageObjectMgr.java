package managers;


import org.openqa.selenium.support.PageFactory;

public class PageObjectMgr {
    PageObjectMgr pageObjectMgr;

    static Object currentPage;

    public Object getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String pageNm) throws Exception{
        try {
            currentPage = PageFactory.initElements(Driver.getDriver(), Class.forName("PageFactory."+pageNm));
        } catch (ClassNotFoundException e) {
            throw new Exception("Class not found to initialize" +pageNm);
        }
    }


    public  PageObjectMgr(){
    }

}
