package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobTest {
    @Test
    public void whenJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Repair road", 1),
                new Job("Chop grass", 2),
                new Job("Build home", 3)
        );
        List<Job> expected = Arrays.asList(
                jobs.get(2),
                jobs.get(1),
                jobs.get(0)
        );
        Collections.sort(jobs, new JobAscByName());
        assertEquals(jobs, expected);
    }

    @Test
    public void whenJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Repair road", 1),
                new Job("Build home", 2),
                new Job("Chop grass", 3)
        );
        List<Job> expected = Arrays.asList(
                jobs.get(0),
                jobs.get(2),
                jobs.get(1)
        );
        Collections.sort(jobs, new JobDescByName());
        assertEquals(jobs, expected);
    }

    @Test
    public void whenJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Chop grass", 2),
                new Job("Repair road", 1),
                new Job("Build home", 3)
        );
        List<Job> expected = Arrays.asList(
                jobs.get(1),
                jobs.get(0),
                jobs.get(2)
        );
        Collections.sort(jobs, new JobAscByPriority());
        assertEquals(jobs, expected);
    }

    @Test
    public void whenJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Repair road", 1),
                new Job("Build home", 2),
                new Job("Chop grass", 3)
        );
        List<Job> expected = Arrays.asList(
                jobs.get(2),
                jobs.get(1),
                jobs.get(0)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertEquals(jobs, expected);
    }

    @Test
    public void whenComparatorAscByPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        List<Job> jobs = Arrays.asList(
                new Job("Repair road", 1),
                new Job("Build home", 2),
                new Job("Chop grass", 3),
                new Job("Fix auto", 1),
                new Job("Paint wall", 2),
                new Job("Install window", 3)
        );
        List<Job> expected = Arrays.asList(
                jobs.get(3),
                jobs.get(0),
                jobs.get(1),
                jobs.get(4),
                jobs.get(2),
                jobs.get(5)
        );
        Collections.sort(jobs, cmpNamePriority);
        assertEquals(jobs, expected);
    }

    @Test
    public void whenComparatorDescByPriorityAndAscName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobAscByName());
        List<Job> jobs = Arrays.asList(
                new Job("Repair road", 1),
                new Job("Build home", 2),
                new Job("Chop grass", 3),
                new Job("Fix auto", 1),
                new Job("Paint wall", 2),
                new Job("Install window", 3)
        );
        List<Job> expected = Arrays.asList(
                jobs.get(2),
                jobs.get(5),
                jobs.get(1),
                jobs.get(4),
                jobs.get(3),
                jobs.get(0)
        );
        Collections.sort(jobs, cmpNamePriority);
        assertEquals(jobs, expected);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}
