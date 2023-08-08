package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double avgScore = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                avgScore += subject.score();
                count++;
            }
        }
        return avgScore / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> listOfPupils = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double avgScore = 0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                avgScore += subject.score();
                count++;
            }
            Label label = new Label(pupil.name(), avgScore / count);
            listOfPupils.add(label);
        }
        return listOfPupils;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> avgScoreBySubject = new LinkedHashMap<>();
        List<Label> listOfSubjects = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                avgScoreBySubject.put(subject.name(),
                        avgScoreBySubject.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String subject : avgScoreBySubject.keySet()) {
            double score = avgScoreBySubject.get(subject);
            Label label = new Label(subject, score / pupils.size());
            listOfSubjects.add(label);
        }
        return listOfSubjects;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> listOfPupils = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            Label label = new Label(pupil.name(), totalScore);
            listOfPupils.add(label);
        }
        listOfPupils.sort(Comparator.naturalOrder());
        return listOfPupils.get(listOfPupils.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> totalScoreBySubject = new LinkedHashMap<>();
        List<Label> listOfSubjects = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScoreBySubject.put(subject.name(),
                        totalScoreBySubject.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String subject : totalScoreBySubject.keySet()) {
            Label label = new Label(subject, totalScoreBySubject.get(subject));
            listOfSubjects.add(label);
        }
        listOfSubjects.sort(Comparator.naturalOrder());
        return listOfSubjects.get(listOfSubjects.size() - 1);
    }
}
