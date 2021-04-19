package com.example.fragmentslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    ViewPagerAdapter adapter;

    @BindView(R.id.pager)
    ViewPager2 viewPager2;

    @BindView(R.id.tab)
    TabLayout tabLayout;

    public ViewPagerAdapter getAdapter() {
        if(adapter == null)
            adapter= new ViewPagerAdapter(this);
        return adapter;
    }

    public void setAdapter(ViewPagerAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPager2.setAdapter(getAdapter());

        //configurando el tab , iconos y texto
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout,viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position+1) {
                            case 1: tab.setText("Opcion 1");
                                //badges es una forma de notificar que algo esta pasando
                                tab.setIcon(R.drawable.ic_baseline_policy_24);
                                BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                                //A la tipo alerta ponerle un numero de notificaciones
                                //el numero maximo de  digitos en la nofiticacion
                                badgeDrawable.setMaxCharacterCount(1);
                                badgeDrawable.setNumber(50);
                                //aplicarle un background de fondo
                                badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.teal_200));
                                //´para que se muestre
                                badgeDrawable.setVisible(true);
                                break;
                            case 2: tab.setText("Opcion 2");
                                tab.setIcon(R.drawable.ic_launcher_foreground);
                                break;
                            case 3: tab.setText("Opcion 3");
                                tab.setIcon(R.drawable.ic_baseline_whatshot_24);
                                break;
                            case 4: tab.setText("Opcion 4");
                                break;
                        }
                    }
                });
        //para que se muestre
        tabLayoutMediator.attach();
    }

}