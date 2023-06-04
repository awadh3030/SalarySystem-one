package com.codeline.sampleProject.Repository;

import com.codeline.sampleProject.Models.Manager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManagerRepository {
    @Query("SELECT * FROM Manager WHERE teamName=:nameOfTeam")
    Manager getManagerByTeamName(@Param("nameOfTeam") String teamName);
}
