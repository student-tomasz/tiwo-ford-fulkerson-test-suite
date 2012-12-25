package algs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    algs.performance.network.CompleteGraphs.class,
    algs.performance.network.SparseVsDense.class,
    algs.performance.network.DegenerateCaseTest.class,
    algs.performance.network.Figure8_3Test.class,
    algs.performance.network.Figure8_7Test.class,
    algs.performance.network.Figure_FactSheet_FordFulkersonTest.class,
    algs.performance.network.FinalCaseTest.class,
    algs.network.CormenExampleTest.class,
    algs.network.ExampleTest.class,
    algs.network.SampleBackflowTest.class,
    algs.network.SimpleTest.class,
    algs.network.WebExampleTest.class
})
public class CompleteTestSuite {
    
}
