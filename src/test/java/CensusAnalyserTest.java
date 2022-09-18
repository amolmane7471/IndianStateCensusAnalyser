import com.bridgelabz.CensusAnalyser;
import com.bridgelabz.CensusAnalyserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\manea\\IdeaProjects\\day29_CensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "C:\\Users\\manea\\IdeaProjects\\day29_CensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String INDIA_STATE_CODE_CSV = " C:\\Users\\manea\\IdeaProjects\\day29_CensusAnalyser\\src\\test\\resources\\IndiaStateCode.csv";
    private static final String WRONG_STATE_CSV_FILE_PATH = " C:\\Users\\manea\\IdeaProjects\\day29_CensusAnalyser\\src\\test\\resources\\IndiaStateCode.csv";
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
            System.out.println("Welcome to Census Analyser problem ");
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void givenIndiaStateCodeCSVFile_WhenCorrectPath_ShouldReturnsCorrectRecords()
    {
        try
        {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_STATE_CODE_CSV);
            Assertions.assertEquals(37,numOfRecords);
        }
        catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndianStateCodeCSVFile_WhenWithWrongFilePath_ShouldThrowException()
    {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(WRONG_STATE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
}