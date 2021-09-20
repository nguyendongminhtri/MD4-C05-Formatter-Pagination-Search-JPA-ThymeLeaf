package chinh.anh.fomatter;

import chinh.anh.model.Province;
import chinh.anh.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class ProvinceFormatter implements Formatter<Province> {
    //Đoạn này ko Autowired vì a sử dụng ở contructor bên dưới
    private IProvinceService provinceService;

    @Autowired
    public  ProvinceFormatter(IProvinceService provinceService) {

        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        Optional<Province> province = provinceService.findById(Long.parseLong(text));
        return province.orElse(null);
    }

    @Override
    public String print(Province province, Locale locale) {
        return "["+province.getId()+","+province.getName()+"]";
    }
}
