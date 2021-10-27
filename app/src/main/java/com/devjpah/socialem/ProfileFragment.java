package com.devjpah.socialem;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    TextView tvTitle, tvCountFollows, tvCountStars, tvName, tvProfession, tvJob, tvLocation;
    CircleImageView imgProfile;
    ImageButton imgbFollow, imgbStar, imgbEdit;
    RecyclerView publicationsProfile;
    List<Publication> publications = new ArrayList<Publication>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        connectXml(view);
        initPublications();

        //Events
        imgbFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Follow", Toast.LENGTH_SHORT).show();
            }
        });

        imgbStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Star", Toast.LENGTH_SHORT).show();
            }
        });

        imgbEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Edit info", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(),EditProfileActivity.class));
            }
        });
        return view;
    }

    private void initPublications() {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment("eli@h.com", "Que juiciioooooo"));
        //Request Options
        publications.add(new Publication("Juliana De la rosa", "20211020", "media\\fddfs.png", "Trabajando ando", 34, comments));
        publications.add(new Publication("Juliana De la rosa", "20211020", "media\\fddfs.png", "Trabajando ando", 34, comments));
        publications.add(new Publication("Juliana De la rosa", "20211020", "media\\fddfs.png", "Trabajando ando", 34, comments));
        publications.add(new Publication("Juliana De la rosa", "20211020", "media\\fddfs.png", "Trabajando ando", 34, comments));
        publications.add(new Publication("Juliana De la rosa", "20211020", "media\\fddfs.png", "Trabajando ando Trabajando ando OEEE Trabajando ando Trabajando ando Trabajando ando Trabajando ando Trabajando ando Trabajando ando Trabajando ando Trabajando ando", 34, comments));
        //Create feed
        PublicationsAdapter adapter = new PublicationsAdapter(publications, getContext());
        publicationsProfile.setAdapter(adapter);
        publicationsProfile.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }

    private void connectXml(View view) {
        tvTitle = view.findViewById(R.id.tv_title);
        tvCountFollows = view.findViewById(R.id.tv_count_follows);
        tvCountStars = view.findViewById(R.id.tv_count_stars);
        tvName = view.findViewById(R.id.tv_name);
        tvProfession = view.findViewById(R.id.tv_profession);
        tvJob = view.findViewById(R.id.tv_job);
        tvLocation = view.findViewById(R.id.tv_location);
        imgProfile = view.findViewById(R.id.img_profile_edit);
        imgbFollow = view.findViewById(R.id.imgb_follow);
        imgbStar = view.findViewById(R.id.imgb_star);
        imgbEdit = view.findViewById(R.id.imgb_edit);
        publicationsProfile = view.findViewById(R.id.publications_profile);
    }
}