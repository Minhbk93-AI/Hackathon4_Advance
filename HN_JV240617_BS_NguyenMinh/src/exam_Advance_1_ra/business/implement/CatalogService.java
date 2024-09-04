package exam_Advance_1_ra.business.implement;

import exam_Advance_1_ra.business.design.ICatalogService;
import exam_Advance_1_ra.business.entity.Catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogService implements ICatalogService {

    private static ArrayList<Catalog> catalogs = new ArrayList<>();
static {
    catalogs.add(new Catalog(1,"Pháp Luật","Pháp luât Việt Nam"));
    catalogs.add(new Catalog(2,"Khoa học công nghệ","Công nghệ 4.0"));
    catalogs.add(new Catalog(3,"Kinh tế","Kinh tế thế giới"));
}
//get Arraylist catalogs
@Override
public List<Catalog> getAll() {
    return catalogs;
}

//Add or update catalog
@Override
public void save(Catalog catalog) {
    Scanner sc = new Scanner(System.in);
    if(findById(catalog.getCatalogId()) == null){
        catalogs.add(catalog);
    }else{
        catalog.saveData(sc);
        catalogs.set(findIndexById(catalog.getCatalogId()),catalog);
        System.out.println("Cập nhật catalog thành công");
    }

}

//find Catalog by Id
@Override
public Catalog findById(Integer integer) {
    for(Catalog catalog: catalogs){
        if(catalog.getCatalogId() == integer){
            return catalog;
        }
    }
    return null;
}

//delete catalog by id
@Override
public void delete(Integer integer) {
    if(findById(integer) == null){
        System.err.println("Khng thể tìm kiềm catalog với Id: " + integer);
    }else{
        catalogs.remove(findById(integer));
    }
}

//find index catalog by id
public int findIndexById(Integer id){
    for(int i = 0; i < catalogs.size();i++){
        if(catalogs.get(i).getCatalogId() == id){
            return i;
        }
    }
    return -1;
}
}

