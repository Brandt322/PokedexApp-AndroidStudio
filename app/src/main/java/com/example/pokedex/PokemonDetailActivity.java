package com.example.pokedex;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokedex.network.PokemonLoader;
import com.example.pokedex.network.model.Abilities;
import com.example.pokedex.network.model.Ability;
import com.example.pokedex.network.model.PokemonByIdResponse;
import com.example.pokedex.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetailActivity extends AppCompatActivity {

    TextView tvPokemonAbilityList, tvPokemonExp, tvPokemonTitle;
    RecyclerView rvPokemonGameList;
    ImageView ivPokemonSprite;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        tvPokemonTitle = findViewById(R.id.tvPokemonTitle);
        tvPokemonExp = findViewById(R.id.tvPokemonExp);
        tvPokemonAbilityList = findViewById(R.id.tvPokemonAbilityList);
        rvPokemonGameList = findViewById(R.id.rvPokemonGameList);
        ivPokemonSprite = findViewById(R.id.ivPokemonSprite);


        String pokemonId = getIntent().getStringExtra(Constant.POKEMON_ID);
        PokemonLoader loader = new PokemonLoader();

        Call<PokemonByIdResponse> call = loader.getPokemonById(pokemonId);

        call.enqueue(new Callback<PokemonByIdResponse>() {
            @Override
            public void onResponse(Call<PokemonByIdResponse> call, Response<PokemonByIdResponse> response) {
                tvPokemonTitle.setText(response.body().getId()+ "-" + response.body().getName().toUpperCase());
                tvPokemonExp.setText("XP Base: " + response.body().getBaseExperience());

                Glide.with(PokemonDetailActivity.this).load(response.body().getSprite().getImg()).into(ivPokemonSprite);

                List<Ability> abilityList = new ArrayList<>();
                StringBuilder stringBuilder = new StringBuilder();
                for (Abilities abilities : response.body().getAbilities()) {
                    abilityList.add(abilities.getAbility());
                }
                int count = 1;
                for (Ability ability : abilityList) {
                    stringBuilder.append( count++ + ". " + ability.getName() + "\n");
                }

                tvPokemonAbilityList.setText(stringBuilder.toString());
            }

            @Override
            public void onFailure(Call<PokemonByIdResponse> call, Throwable t) {
                Log.e(Constant.DEBUG_POKEMON, t.getMessage());
            }
        });
    }
}
