module ProjectFX {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires Memorygame;
	//requires olioprojekti_card_game;

	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
