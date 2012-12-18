package algs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    algs.example.tests.model.performance.network.CompleteGraphs.class,
    algs.example.tests.model.performance.network.SparseVsDense.class,
    algs.model.performance.network.DegenerateCaseTest.class,
    algs.model.performance.network.Figure8_3Test.class,
    algs.model.performance.network.Figure8_7Test.class,
    algs.model.performance.network.Figure_FactSheet_FordFulkersonTest.class,
    algs.model.performance.network.FinalCaseTest.class,
    algs.network.CormenExampleTest.class,
    algs.network.CreateImageTest.class,
    algs.network.ExampleTest.class,
    algs.network.MaxFlowMinCostTest.class,
    algs.network.SampleBackflowTest.class,
    algs.network.SimpleTest.class,
    algs.network.WebExampleTest.class
})
public class CompleteTestSuite {
    
}
