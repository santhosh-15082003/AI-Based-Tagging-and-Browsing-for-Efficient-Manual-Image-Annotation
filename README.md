# AI Based Tagging and Browsing for Efficient Manual Image Annotation

## Introduction
This project proposes a hybrid manual-annotation framework enhanced with AI-based tagging and browsing strategies. The system combines statistical models and interface design to improve annotation accuracy and reduce labeling time by up to 50%. It supports metadata analysis, histogram context extraction, AI tag suggestion, and manual editing.

## 🚀 Features
- Tagging and browsing interface
- Histogram-based segmentation
- Manual override for label refinement
- Context-aware tag suggestions (EXIF, GPS, calendar)
- Efficient database design and metadata indexing

## 🛠️ Tech Stack
- Language: Java
- Backend: MS Access
- IDE: MyEclipse 6.0
- Platform: Windows XP/8/10
- Additional Tools: EXIF metadata parsing, histogram analysis

## System Architecture & Modules steps
- **Metadata Analysis**: Extracts timestamp, GPS, and user data from images
- **Histogram Context**: Uses image histogram to group segments
- **Tagging**: AI suggests tags; users can confirm/edit
- **Annotation Upload**: Uploads tagged images to server with indices

## Installation & Setup
  ## Prerequisites
    - Java (JDK 1.8 or higher)
    - MyEclipse 6.0
    - MS Access
  
  ## Steps
    1. Clone the repo:
       ```bash
       git clone https://github.com/yourusername/image-annotation-ai.git
       cd image-annotation-ai

    2. Open the project in MyEclipse
    3. Configure MS Access DB connection in the backend code
    4. Run the application

## System Requirements
  ### Hardware:
    - Processor: Intel i3 or above
    - RAM: 2 GB minimum
    - HDD: 500 GB minimum
  
  ### Software:
    - OS: Windows XP / 8 / 10
    - IDE: MyEclipse 6.0
    - Backend: MS Access

## Usage
  1. Launch the application
  2. Upload or browse images
  3. Review AI-suggested tags
  4. Edit or approve tags manually
  5. Save annotations to the database

## Screenshots
  ## Step1 -> After running the program, a main window will appear. Click “Image Training” and then click the “Select” button
  ![Screenshot 2025-06-27 100651](https://github.com/user-attachments/assets/bef6a029-ae9a-4db6-a473-c12b97ccf696)

  ## Step2 -> In the training window that opens, click the “Open” button.
  ![Screenshot 2025-06-27 100754](https://github.com/user-attachments/assets/fde3fc62-b1c5-4343-8906-d0d91540a34f)

  ## Step3 -> A file dialog will appear. Select the image you want to tag and click “Open.”
  ![Screenshot 2025-06-27 100926](https://github.com/user-attachments/assets/bbc96a34-8796-43ad-b146-7077d178c086)

  ## Step4 -> Once the image is loaded, it will be automatically split into segments, each with a label number. Select a specific label number, enter the desired tag name for that segment, and click “Load” to associate the label with the image.
  ![Screenshot 2025-06-27 101108](https://github.com/user-attachments/assets/d4f4e6bd-864d-4f88-83a9-0a717891ab0a)
  ![Screenshot 2025-06-27 101118](https://github.com/user-attachments/assets/3479227c-6158-42e2-a6a9-90c97dc1cf09)

  ## Step5 -> To view images by their labels, click “Multilabelled RS Search Engine” and then click the “Select” button.
  ![Screenshot 2025-06-27 101218](https://github.com/user-attachments/assets/cafc956c-f32d-421d-8a5d-3ee45d0784e7)

  ## Step6 -> The search interface will open. Enter the label name you want to search for and click “Search.” The system will retrieve and display the images tagged with that label.
  ![Screenshot 2025-06-27 101247](https://github.com/user-attachments/assets/8412ff4e-92dd-4257-aa77-51871f2239be)


## Future Enhancement
  - Real-time face/object tagging
  - Cloud storage sync
  - Mobile version support

## 👤 Author
**Santhosh B**  
[GitHub](https://github.com/santhosh-15082003) | santhoshb1503@gmail.com

