package com.ehab.alhaj;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // بيانات المعرض الرسمية
    String kureimiAccount = "308-653-0227";
    String jawaliPoint = "894750";
    String ownerWhatsApp = "967713555661"; // تم إضافة رقمك يا هندسة
    String adminPassword = "2026"; // الرمز السري الافتراضي (يمكنك تغييره)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Toast.makeText(this, "مرحباً بك في معرض أيهاب الحاج", Toast.LENGTH_LONG).show();
    }

    // دالة إرسال الطلب عبر الواتساب مباشرة لصاحب المحل
    public void sendOrder(String productTitle, String price) {
        String message = "السلام عليكم، أريد طلب هذه القطعة من معرض أيهاب الحاج:\n" +
                         "اسم المنتج: " + productTitle + "\n" +
                         "السعر: " + price + "\n\n" +
                         "طريقة الدفع المختارة:\n" +
                         "- كريمي: " + kureimiAccount + "\n" +
                         "- جوالي: " + jawaliPoint;
        
        try {
            String url = "https://api.whatsapp.com/send?phone=" + ownerWhatsApp + "&text=" + Uri.encode(message);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } catch (Exception e) {
            Toast.makeText(this, "تأكد من تثبيت واتساب لإتمام الطلب", Toast.LENGTH_SHORT).show();
        }
    }

    // لوحة التحكم (تظهر عند استدعائها برمز سري)
    public void openAdminPanel(String inputPass) {
        if (inputPass.equals(adminPassword)) {
            // كود فتح شاشة إضافة المنتجات
            Toast.makeText(this, "تم الدخول للوحة التحكم", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "الرمز السري خطأ!", Toast.LENGTH_SHORT).show();
        }
    }
}
