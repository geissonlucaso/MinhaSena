package udm.geisson.minhasenaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Constantes.
    private final int QUANTIDADE_NUMEROS_SORTEADOS = 6;
    private final int INTERVALO_NUMEROS_POSSIVEIS = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sorteioNumeros(View view) {

        TextView tvnumeros = findViewById(R.id.tv_numeros);
        String jogo = "";

        int[] numerosSorteados = new int[QUANTIDADE_NUMEROS_SORTEADOS];
        for (int i = 0; i < numerosSorteados.length; i++) {
            int numero = (new Random().nextInt(INTERVALO_NUMEROS_POSSIVEIS)) + 1;
            numerosSorteados[i] = numero;
        }

        bubbleSort(numerosSorteados);
        refatoraNumerosRepetidos(numerosSorteados);

        for (int i = 0; i < numerosSorteados.length; i++) {
            if (numerosSorteados[i] < 10)
                jogo += " * " + "0" + numerosSorteados[i];
            else
                jogo += " * " + numerosSorteados[i];
        }
        jogo += " * ";

        tvnumeros.setText(jogo);
    }

    private void bubbleSort(int[] vet) {
        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = 0; j < vet.length - 1; j++) {
                if (vet[j] > vet[j+1]) {
                    int aux = vet[j];
                    vet[j] = vet[j+1];
                    vet[j+1] = aux;
                }
            }
        }
    }

    private void refatoraNumerosRepetidos(int[] vet) {
        for (int i = 0; i < vet.length - 1; i++) {
            if (vet[i] == vet[i+1]) {
                vet[i] = (vet[i] - 1)/3;
            }
        }
        bubbleSort(vet);
    }
}