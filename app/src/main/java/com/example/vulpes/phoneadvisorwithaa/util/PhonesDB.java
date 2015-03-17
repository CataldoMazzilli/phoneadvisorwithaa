package com.example.vulpes.phoneadvisorwithaa.util;

import com.example.vulpes.phoneadvisorwithaa.R;
import com.example.vulpes.phoneadvisorwithaa.models.Brand;
import com.example.vulpes.phoneadvisorwithaa.models.Phone;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by vulpes on 02/12/14.
 */
public class PhonesDB {

    private ArrayList<Brand> db;
    private static PhonesDB instance;

    private PhonesDB() {
        db = new ArrayList<Brand>();
        ArrayList<Phone> constructorSamsung = new ArrayList<Phone>();

        constructorSamsung.add(new Phone("Samsung", R.drawable.samsung_galaxy_a5, "Samsung Galaxy A5"));
        constructorSamsung.add(new Phone("Samsung", R.drawable.samsung_galaxy_note_4, "Samsung Galaxy Note 4"));
        constructorSamsung.add(new Phone("Samsung", R.drawable.samsung_galaxy_alpha, "Samsung Galaxy Alpha"));
        constructorSamsung.add(new Phone("Samsung", R.drawable.samsung_galaxy_s5, "Samsung Galaxy S5"));
        constructorSamsung.add(new Phone("Samsung", R.drawable.samsung_galaxy_grand, "Samsung Galaxy Grand"));
        constructorSamsung.add(new Phone("Samsung", R.drawable.samsung_galaxy_chat, "Samsung Galaxy Chat"));
        constructorSamsung.add(new Phone("Samsung", R.drawable.samsung_galaxy_s3, "Samsung Galaxy S3"));
        constructorSamsung.add(new Phone("Samsung", R.drawable.samsung_galaxy_pocket, "Samsung Galaxy Pocket"));
        constructorSamsung.add(new Phone("Samsung", R.drawable.samsung_galaxy_y, "Samsung Galaxy Y"));
        constructorSamsung.add(new Phone("Samsung", R.drawable.samsung_corby_ii, "Samsung Corby II"));
        db.add(new Brand("Samsung", R.drawable.logo_samsung, constructorSamsung));

        ArrayList<Phone> constructorSony = new ArrayList<Phone>();
        constructorSony.add(new Phone("Sony", R.drawable.sony_xperia_z3, "Sony Xperia Z3"));
        constructorSony.add(new Phone("Sony", R.drawable.sony_xperia_c3, "Sony Xperia C3"));
        constructorSony.add(new Phone("Sony", R.drawable.sony_xperia_c, "Sony Xperia C"));
        constructorSony.add(new Phone("Sony", R.drawable.sony_xperia_z, "Sony Xperia Z"));
        constructorSony.add(new Phone("Sony", R.drawable.sony_xperia_ion, "Sony Xperia Ion"));
        constructorSony.add(new Phone("Sony", R.drawable.sony_xperia_tipo, "Sony Xperia tipo"));
        constructorSony.add(new Phone("Sony", R.drawable.sony_xperia_sole, "Sony Xperia sole"));
        constructorSony.add(new Phone("Sony", R.drawable.sony_cmd_z7, "Sony CMD Z7"));
        constructorSony.add(new Phone("Sony", R.drawable.sony_xperia_miro, "Sony Xperia miro"));
        constructorSony.add(new Phone("Sony", R.drawable.sony_xperia_go, "Sony Xperia go"));
        db.add(new Brand("Sony", R.drawable.logo_sony, constructorSony));

        ArrayList<Phone> constructorLg = new ArrayList<Phone>();
        constructorLg.add(new Phone("Lg", R.drawable.lg_g3, "LG Electronics G3"));
        constructorLg.add(new Phone("Lg", R.drawable.lg_l70, "LG Electronics L70"));
        constructorLg.add(new Phone("Lg", R.drawable.lg_nexus_5, "LG Electronics Nexus 5"));
        constructorLg.add(new Phone("Lg", R.drawable.lg_g2, "LG Electronics G2"));
        constructorLg.add(new Phone("Lg", R.drawable.lg_google_nexus_4, "LG Electronics Google Nexus 4"));
        constructorLg.add(new Phone("Lg", R.drawable.lg_optimus_dual, "LG Electronics Optimus Dual"));
        constructorLg.add(new Phone("Lg", R.drawable.lg_l90, "LG Electronics L90"));
        constructorLg.add(new Phone("Lg", R.drawable.lg_l40, "LG Electronics L40"));
        constructorLg.add(new Phone("Lg", R.drawable.lg_g_flex, "LG Electronics G Flex"));
        constructorLg.add(new Phone("Lg", R.drawable.lg_optimus_net, "LG Electronics Optimus Net"));
        db.add(new Brand("Lg", R.drawable.logo_lg, constructorLg));

        ArrayList<Phone> constructorApple = new ArrayList<Phone>();
        constructorApple.add(new Phone("Apple", R.drawable.apple_iphone_6_plus, "Apple iPhone 6 Plus"));
        constructorApple.add(new Phone("Apple", R.drawable.apple_iphone_6, "Apple iPhone 6"));
        constructorApple.add(new Phone("Apple", R.drawable.apple_iphone_5s, "Apple iPhone 5S"));
        constructorApple.add(new Phone("Apple", R.drawable.apple_iphone_5c, "Apple iPhone 5C"));
        constructorApple.add(new Phone("Apple", R.drawable.apple_iphone_5, "Apple iPhone 5"));
        constructorApple.add(new Phone("Apple", R.drawable.apple_iphone_4s, "Apple iPhone 4S"));
        constructorApple.add(new Phone("Apple", R.drawable.apple_iphone_4, "Apple iPhone 4"));
        constructorApple.add(new Phone("Apple", R.drawable.apple_iphone_3gs, "Apple iPhone 3G S"));
        constructorApple.add(new Phone("Apple", R.drawable.apple_iphone_3g, "Apple iPhone 3G"));
        constructorApple.add(new Phone("Apple", R.drawable.apple_iphone, "Apple iPhone"));
        db.add(new Brand("Apple", R.drawable.logo_apple, constructorApple));

        ArrayList<Phone> constructorNokia = new ArrayList<Phone>();
        constructorNokia.add(new Phone("Nokia", R.drawable.lumia_830, "Nokia Lumia 830"));
        constructorNokia.add(new Phone("Nokia", R.drawable.lumia_735, "Nokia Lumia 735"));
        constructorNokia.add(new Phone("Nokia", R.drawable.lumia_530, "Nokia Lumia 530"));
        constructorNokia.add(new Phone("Nokia", R.drawable.lumia_930, "Nokia Lumia 930"));
        constructorNokia.add(new Phone("Nokia", R.drawable.lumia_630, "Nokia Lumia 630"));
        constructorNokia.add(new Phone("Nokia", R.drawable.asha_502, "Nokia Asha 502"));
        constructorNokia.add(new Phone("Nokia", R.drawable.lumia_2520, "Nokia Lumia 2520"));
        constructorNokia.add(new Phone("Nokia", R.drawable.lumia_1520, "Nokia Lumia 1520"));
        constructorNokia.add(new Phone("Nokia", R.drawable.asha_310, "Nokia Asha 310"));
        constructorNokia.add(new Phone("Nokia", R.drawable.asha_210, "Nokia Asha 210"));
        db.add(new Brand("Nokia", R.drawable.logo_nokia, constructorNokia));

        ArrayList<Phone> constructorHuawei = new ArrayList<Phone>();
        constructorHuawei.add(new Phone("Huawei", R.drawable.huawei_ascend_g7, "Huawei Ascend G7"));
        constructorHuawei.add(new Phone("Huawei", R.drawable.huawei_ascend_mate_7, "Huawei Ascend Mate 7"));
        constructorHuawei.add(new Phone("Huawei", R.drawable.huawei_ascend_p7, "Huawei Ascend P7"));
        constructorHuawei.add(new Phone("Huawei", R.drawable.ascend_g6, "Huawei Ascend G6"));
        constructorHuawei.add(new Phone("Huawei", R.drawable.huawei_honor_3c, "Huawei Honor 3C"));
        constructorHuawei.add(new Phone("Huawei", R.drawable.huawei_ascend_p6, "Huawei Ascend P6"));
        constructorHuawei.add(new Phone("Huawei", R.drawable.huawei_ascend_y300, "Huawei Ascend Y300"));
        constructorHuawei.add(new Phone("Huawei", R.drawable.huawei_ascend_p2, "Huawei Ascend P2"));
        constructorHuawei.add(new Phone("Huawei", R.drawable.huawei_sonic, "Huawei Sonic"));
        constructorHuawei.add(new Phone("Huawei", R.drawable.huawei_vision, "Huawei Vision"));
        db.add(new Brand("Huawei", R.drawable.logo_huawei, constructorHuawei));

        ArrayList<Phone> constructorAsus = new ArrayList<Phone>();
        constructorAsus.add(new Phone("Asus", R.drawable.asus_padfone_infinity, "Asus Padfone Infinity"));
        constructorAsus.add(new Phone("Asus", R.drawable.asus_fonepad, "Asus Fonepad"));
        constructorAsus.add(new Phone("Asus", R.drawable.asus_e600, "Asus E600"));
        constructorAsus.add(new Phone("Asus", R.drawable.asus_p835, "Asus P835"));
        constructorAsus.add(new Phone("Asus", R.drawable.asus_p565, "Asus P565"));
        constructorAsus.add(new Phone("Asus", R.drawable.asus_p320, "Asus P320"));
        constructorAsus.add(new Phone("Asus", R.drawable.asus_p560, "Asus P560"));
        constructorAsus.add(new Phone("Asus", R.drawable.asus_m530w, "Asus M530w"));
        constructorAsus.add(new Phone("Asus", R.drawable.asus_p735, "Asus P735"));
        constructorAsus.add(new Phone("Asus", R.drawable.asus_p505, "Asus P505"));
        db.add(new Brand("Asus", R.drawable.logo_asus, constructorAsus));

        ArrayList<Phone> constructorHtc = new ArrayList<Phone>();
        constructorHtc.add(new Phone("Htc", R.drawable.htc_one_m9, "HTC One M9"));
        constructorHtc.add(new Phone("Htc", R.drawable.htc_desire_eye, "HTC Desire Eye"));
        constructorHtc.add(new Phone("Htc", R.drawable.desire_620, "HTC Desire 620"));
        constructorHtc.add(new Phone("Htc", R.drawable.htc_nexus_9, "HTC Nexus 9"));
        constructorHtc.add(new Phone("Htc", R.drawable.htc_one_m8, "HTC One M8"));
        constructorHtc.add(new Phone("Htc", R.drawable.htc_desire_816, "HTC Desire 816"));
        constructorHtc.add(new Phone("Htc", R.drawable.htc_one_max, "HTC One Max"));
        constructorHtc.add(new Phone("Htc", R.drawable.htc_one_mini, "HTC One mini"));
        constructorHtc.add(new Phone("Htc", R.drawable.htc_butterfly_s, "HTC Butterfly S"));
        constructorHtc.add(new Phone("Htc", R.drawable.htc_first, "HTC First"));
        db.add(new Brand("Htc", R.drawable.logo_htc, constructorHtc));

        ArrayList<Phone> constructorMotorola = new ArrayList<Phone>();
        constructorMotorola.add(new Phone("Motorola", R.drawable.motorola_moto_g, "Motorola Moto G"));
        constructorMotorola.add(new Phone("Motorola", R.drawable.motorola_nexus_6, "Motorola Nexus 6"));
        constructorMotorola.add(new Phone("Motorola", R.drawable.motorola_moto_maxx, "Motorola Moto Maxx"));
        constructorMotorola.add(new Phone("Motorola", R.drawable.motorola_moto_e, "Motorola Moto E"));
        constructorMotorola.add(new Phone("Motorola", R.drawable.motorola_moto_x, "Motorola Moto X"));
        constructorMotorola.add(new Phone("Motorola", R.drawable.motorola_defy_mini, "Motorola Defy Mini"));
        constructorMotorola.add(new Phone("Motorola", R.drawable.motorola_fire, "Motorola FIRE"));
        constructorMotorola.add(new Phone("Motorola", R.drawable.motorola_wilder, "Motorola Wilder"));
        constructorMotorola.add(new Phone("Motorola", R.drawable.motorola_aura, "Motorola Aura"));
        constructorMotorola.add(new Phone("Motorola", R.drawable.motorola_c115, "Motorola C115"));
        db.add(new Brand("Motorola", R.drawable.logo_motorola, constructorMotorola));
    }

    public static PhonesDB getInstance() {
        if (instance == null) {
            instance = new PhonesDB();
        }
        return instance;
    }

    public ArrayList<Brand> getAllBrand() {
        return db;
    }

    public Brand getBrandById(int id) {

        Brand output = null;
        Iterator<Brand> iterator = db.iterator();
        while (iterator.hasNext()) {
            Brand brand = iterator.next();
            if (brand.getId() == id) output = brand;
        }
        return output;
    }

    public ArrayList<Phone> getPhoneById(int[] favouritesId) {
        ArrayList<Phone> output = new ArrayList<Phone>();
        Iterator<Brand> iteratorB = db.iterator();
        while (iteratorB.hasNext()) {
            Brand brand = iteratorB.next();
            Iterator<Phone> iteratorP = brand.getmPhoneList().iterator();
            while (iteratorP.hasNext()) {
                Phone phone = iteratorP.next();
                for (int i = 0; i < favouritesId.length; i++) {
                    if (phone.getId() == favouritesId[i]) {
                        output.add(phone);
                    }
                }
            }
        }
        return output;
    }
}