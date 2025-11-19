# Fall Detection using Image Pre-Processing & Machine Learning

This project identifies whether a fall has occurred using image pre-processing, feature extraction, and machine-learning classification.  
It uses traditional computer vision techniques (BRISK, BRIEF, STAR, Canny edges, histogram equalization) combined with ML models.

---

## Repository Contents

### 1. Basic Preprocessing and Feature Extraction  
**File:** Basic Preprocessing and feature Extraction.py  
- Preprocesses images (resize, grayscale, blur, histogram equalization, edges)  
- Extracts BRISK, STAR, BRIEF descriptors  
- Performs K-Means clustering  
- Generates:
  - Fall1.csv  
  - NoFall1.csv  
  - finalData.csv  
  - finalFolder1.csv  
  - finalFolder2.csv  
  - FinalF.csv  
  - Kmeans.sav  

### 2. Classifier Training and Testing  
**File:** Classifier and testing.py  
- Loads processed feature CSV files  
- Trains models:
  - Random Forest  
  - Decision Tree  
  - KNN  
- Outputs accuracy and predictions  

### 3. Image Background Removal Notebook  
**File:** Image Background Remove (Preprocessing).ipynb  
- Demonstrates background removal using rembg  
- Helps reduce noise before feature extraction  

### 4. Installation Instructions  
**File:** Instructions For installing rembg.txt  
- Contains steps to install the rembg library  

### 5. Dataset Link  
**File:** Link For Dataset Images (Fall and No Fall).txt  
- Contains link to download the Fall and No-Fall dataset  

---

## Project Workflow

### 1. Image Pre-Processing
- Resize images to 100×100  
- Convert to grayscale  
- Apply Gaussian blur  
- Perform histogram equalization  
- Apply Canny edge detection  
- Optional background removal  

### 2. Feature Extraction
- Use BRISK descriptor  
- Use STAR keypoint detector  
- Use BRIEF descriptor  
- Store extracted features in CSV files  

### 3. Clustering (Unsupervised)
- Train K-Means with 3 clusters  
- Save model as Kmeans.sav  
- Convert descriptors into cluster histograms  

### 4. Classification
- Train models using histogram data:
  - Random Forest  
  - Decision Tree  
  - KNN  
- Compare model accuracies  

---

## Summary
This project provides a complete pipeline from image pre-processing to ML classification for detecting fall events using traditional computer vision and machine-learning techniques.
