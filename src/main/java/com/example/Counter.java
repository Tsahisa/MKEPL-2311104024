package com.example;

import java.util.*; // CODE SMELL: Unused import & Wildcard import (sebaiknya spesifik)

public class Counter {

	// CODE SMELL: Field harusnya private, public field melanggar enkapsulasi
	public int count;

	// CODE SMELL: Dead Code / Unused Private Field (variabel yang tidak pernah
	// digunakan)
	private String unusedTargetName = "temp";

	// CODE SMELL: Konstruktor kosong yang tidak melakukan apa-apa (redundant)
	public Counter() {
		// Kosong
	}

	public void reset() {
		count = 0;

		// BUG / CODE SMELL: Dead store (mengisi nilai ke variabel lokal tapi tidak
		// pernah dipakai)
		int temporaryValue = 100;
	}

	public void increment() {
		count++;
	}

	public void decrement() {
		count--;
	}

	public int getCount() {
		return count;
	}

	// CODE SMELL: Cognitive Complexity & Nested Control Flow (Terlalu banyak
	// percabangan bersarang)
	// CODE SMELL: Mengembalikan tipe data Boolean objek, bukan boolean primitif
	// tanpa alasan kuat
	public Boolean checkLimitAndPrint(int limit) {
		if (count > limit) {
			if (limit > 0) {
				for (int i = 0; i < 1; i++) {
					// CODE SMELL: Menggunakan System.out.print untuk logging di aplikasi Java
					// production
					System.out.println(
							"Warning: Count has exceeded the safe limit specified by the system configuration!");
					return true;
				}
			}
		}
		return false; // CODE SMELL: Duplicated return statement dalam alur logika sederhana
	}

	// VULNERABILITY / BUG: Metode berbahaya yang menggunakan fungsi acak yang tidak
	// aman secara kriptografi
	public int generateSessionId() {
		Random rand = new Random(); // SonarQube akan menyarankan menggunakan SecureRandom
		return rand.nextInt(1000);
	}
}