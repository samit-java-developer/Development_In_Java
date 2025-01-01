package com.samit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParallelCandidateScoreCalculator {

	// Batch size for fetching records
	private static final int BATCH_SIZE = 10000;

	public static Map<Integer, Integer> calculateCustomScoresParallel()
			throws InterruptedException, ExecutionException {
		// Database connection details
		String url = "jdbc:mysql://localhost:3306/temp";
		String user = "root";
		String password = "samit@123";

		// Total number of rows in the database (fetch this dynamically if needed)
		int totalRows = getTotalRowCount(url, user, password);

		// ExecutorService to process batches in parallel
		ExecutorService executorService = Executors.newFixedThreadPool(10); // Adjust thread count as needed

		// Thread-safe map to store total scores for each candidate
		Map<Integer, Integer> candidateScores = new ConcurrentHashMap<>();

		// List of Future tasks
		List<Future<?>> futures = new ArrayList<>();

		// Submit tasks for each batch
		for (int offset = 0; offset < totalRows; offset += BATCH_SIZE) {
			final int batchOffset = offset;

			futures.add(executorService.submit(() -> {
				try (Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement stmt = conn.prepareStatement(
								"SELECT candidate_id, question_id, score FROM candidate_scores LIMIT ? OFFSET ?")) {

					stmt.setInt(1, BATCH_SIZE);
					stmt.setInt(2, batchOffset);

					try (ResultSet rs = stmt.executeQuery()) {
						// Process each row in the batch
						while (rs.next()) {
							int candidateId = rs.getInt("candidate_id");
							int questionId = rs.getInt("question_id");
							int score = rs.getInt("score");

							// Apply custom calculation
							int calculatedScore = applyCustomCalculation(questionId, score);

							// Update the total score for the candidate
							candidateScores.merge(candidateId, calculatedScore, Integer::sum);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}));
		}

		// Wait for all tasks to complete
		for (Future<?> future : futures) {
			future.get(); // Ensures the task is complete
		}

		// Shutdown the executor
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);

		return candidateScores;
	}

	// Helper method to get the total row count
	private static int getTotalRowCount(String url, String user, String password) {
		String countQuery = "SELECT COUNT(*) FROM candidate_scores";
		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement stmt = conn.prepareStatement(countQuery);
				ResultSet rs = stmt.executeQuery()) {

			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Custom calculation logic for a score based on the question ID
	private static int applyCustomCalculation(int questionId, int score) {
		switch (questionId) {
		case 1:
			return score * 2;
		case 2:
			return score + 5;
		case 3:
			return score / 2;
		default:
			return score;
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long startTime = System.currentTimeMillis();

		Map<Integer, Integer> scores = calculateCustomScoresParallel();
		for (int i = 100000; i < 200000; i++) {
			scores.put(i + 1, i);
		}

		long endTime = System.currentTimeMillis();

		// Print the time taken and results
		System.out.println("Time taken: " + (endTime - startTime) + "ms");
		// scores.forEach((candidateId, totalScore) -> System.out
		// .println("Candidate ID: " + candidateId + ", Total Score: " + totalScore));

		startTime = System.currentTimeMillis();
		System.out.println(scores.keySet().size());
		endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		System.out.println(scores.get(scores.keySet().size() - 1));
		endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		System.out.println(scores.get(scores.keySet().size() - 2));
		endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		System.out.println(scores.get(scores.keySet().size() - 3));
		endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");

	}
}