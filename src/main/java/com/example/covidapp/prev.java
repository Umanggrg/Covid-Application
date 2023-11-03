package com.example.covidapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class prev extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev);

        TextView mt1 = (TextView) findViewById(R.id.t1);
        TextView mt2 = (TextView) findViewById(R.id.t2);
        TextView mt3 = (TextView) findViewById(R.id.t3);
        TextView mt4 = (TextView) findViewById(R.id.t4);
        TextView mt5 = (TextView) findViewById(R.id.t5);
        TextView mt6 = (TextView) findViewById(R.id.t6);
        TextView mt7 = (TextView) findViewById(R.id.t7);
        TextView mt8 = (TextView) findViewById(R.id.t8);


        mt1.setText("About Co-vid 19");
        mt2.setText("Coronaviruses (CoV) are a large family of viruses that cause illness ranging from the common cold to more severe diseases such as Middle East Respiratory Syndrome (MERS-CoV) and Severe Acute Respiratory Syndrome (SARS-CoV). A novel coronavirus (nCoV) is a new strain that has not been previously identified in humans.\n" +
                "Coronaviruses are zoonotic, meaning they are transmitted between animals and people. Detailed investigations found that SARS-CoV was transmitted from civet cats to humans and MERS-CoV from dromedary camels to humans. Several known coronaviruses are circulating in animals that have not yet infected humans.\n" +
                "Common signs of infection include respiratory symptoms, fever, cough, shortness of breath and breathing difficulties. In more severe cases, infection can cause pneumonia, severe acute respiratory syndrome, kidney failure and even death.\n" +
                "Standard recommendations to prevent infection spread include regular hand washing, covering mouth and nose when coughing and sneezing, thoroughly cooking meat and eggs. Avoid close contact with anyone showing symptoms of respiratory illness such as coughing and sneezing.");

        mt3.setText("Symptoms of Covid-19");
        mt4.setText("COVID-19 affects different people in different ways. Most infected people will develop mild to moderate illness and recover without hospitalization.\n" +
                "Most common symptoms:\n" +
                "fever\n" +
                "dry cough\n" +
                "tiredness\n" +
                "Less common symptoms:\n" +
                "aches and pains\n" +
                "sore throat\n" +
                "diarrhoea\n" +
                "conjunctivitis\n" +
                "headache\n" +
                "loss of taste or smell\n" +
                "a rash on skin, or discolouration of fingers or toes\n" +
                "Serious symptoms:\n" +
                "difficulty breathing or shortness of breath\n" +
                "chest pain or pressure\n" +
                "loss of speech or movement\n" +
                "Seek immediate medical attention if you have serious symptoms. Always call before visiting your doctor or health facility.\n" +
                "People with mild symptoms who are otherwise healthy should manage their symptoms at home.\n" +
                "On average it takes 5–6 days from when someone is infected with the virus for symptoms to show, however it can take up to 14 days.");

        mt5.setText("Prevention from Co-vid 19");
        mt6.setText("Protect yourself and others around you by knowing the facts and taking appropriate precautions. Follow advice provided by your local health authority.\n" +
                "To prevent the spread of COVID-19:\n" +
                "Clean your hands often. Use soap and water, or an alcohol-based hand rub.\n" +
                "Maintain a safe distance from anyone who is coughing or sneezing.\n" +
                "Wear a mask when physical distancing is not possible.\n" +
                "Don’t touch your eyes, nose or mouth.\n" +
                "Cover your nose and mouth with your bent elbow or a tissue when you cough or sneeze.\n" +
                "Stay home if you feel unwell.\n" +
                "If you have a fever, cough and difficulty breathing, seek medical attention.\n" +
                "Calling in advance allows your healthcare provider to quickly direct you to the right health facility. This protects you, and prevents the spread of viruses and other infections.\n" +
                "Masks\n" +
                "Masks can help prevent the spread of the virus from the person wearing the mask to others. Masks alone do not protect against COVID-19, and should be combined with physical distancing and hand hygiene. Follow the advice provided by your local health authority.");

        mt7.setText("Treatment of Co-vid 19");
        mt8.setText("Self care\n" +
                "After exposure to someone who has COVID-19, do the following:\n" +
                "Call your health care provider or COVID-19 hotline to find out where and when to get a test.\n" +
                "Cooperate with contact-tracing procedures to stop the spread of the virus.\n" +
                "If testing is not available, stay home and away from others for 14 days.\n" +
                "While you are in quarantine, do not go to work, to school or to public places. Ask someone to bring you supplies.\n" +
                "Keep at least a 1-metre distance from others, even from your family members.\n" +
                "Wear a medical mask to protect others, including if/when you need to seek medical care.\n" +
                "Clean your hands frequently.\n" +
                "Stay in a separate room from other family members, and if not possible, wear a medical mask.\n" +
                "Keep the room well-ventilated.\n" +
                "If you share a room, place beds at least 1 metre apart.\n" +
                "Monitor yourself for any symptoms for 14 days.\n" +
                "Call your health care provider immediately if you have any of these danger signs: difficulty breathing, loss of speech or mobility, confusion or chest pain.\n" +
                "Stay positive by keeping in touch with loved ones by phone or online, and by exercising at home");
    }
}
