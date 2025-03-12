package com.springboot.service;

import com.springboot.model.User;
import com.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getRecommendations(Integer userId, int topN) {
		// Get the user for whom we are searching for recommendations
		User currentUser = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));

		// Determine gender and filter users based on the gender and interests
		List<User> allUsers = userRepository.findByGenderNot(currentUser.getGender()); // Get users of the opposite
																						// gender

		// Filter by age and interests
		List<User> filteredUsers = allUsers.stream().filter(user -> {
			boolean isGenderValid = (currentUser.getGender().equals("male") && user.getGender().equals("female"))
					|| (currentUser.getGender().equals("female") && user.getGender().equals("male"));
			boolean isAgeValid = (currentUser.getGender().equals("male") && user.getAge() < currentUser.getAge())
					|| (currentUser.getGender().equals("female") && user.getAge() > currentUser.getAge());
			boolean hasCommonInterests = user.getInterests().stream()
					.anyMatch(interest -> currentUser.getInterests().contains(interest));

			return isGenderValid && isAgeValid && hasCommonInterests;
		}).sorted((user1, user2) -> {
			// Sort by age for matching gender and interests
			if (currentUser.getGender().equals("male")) {
				return Integer.compare(user1.getAge(), user2.getAge()); // Return youngest females if currentUser is
																		// male
			} else {
				return Integer.compare(user2.getAge(), user1.getAge()); // Return oldest males if currentUser is female
			}
		}).limit(topN).collect(Collectors.toList());

		return filteredUsers;
	}

	public User updateUser(Integer userId, User userDetails) {
		// Check if the user exists
		Optional<User> existingUserOptional = userRepository.findById(userId);
		if (existingUserOptional.isPresent()) {
			User existingUser = existingUserOptional.get();
			// Update the user's details
			existingUser.setName(userDetails.getName());
			existingUser.setAge(userDetails.getAge());
			existingUser.setGender(userDetails.getGender());
			existingUser.setInterests(userDetails.getInterests());

			// Save the updated user
			return userRepository.save(existingUser);
		} else {
			throw new RuntimeException("User not found with id " + userId);
		}
	}

	public void deleteUser(Integer userId) {
		// Check if the user exists
		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			// Delete the user
			userRepository.deleteById(userId);
		} else {
			throw new RuntimeException("User not found with id " + userId);
		}
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
