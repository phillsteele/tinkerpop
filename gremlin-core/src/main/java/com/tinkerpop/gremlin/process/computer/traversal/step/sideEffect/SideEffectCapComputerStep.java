package com.tinkerpop.gremlin.process.computer.traversal.step.sideEffect;

import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.process.computer.MapReduce;
import com.tinkerpop.gremlin.process.computer.traversal.step.sideEffect.mapreduce.SideEffectCapMapReduce;
import com.tinkerpop.gremlin.process.graph.marker.Bulkable;
import com.tinkerpop.gremlin.process.graph.marker.MapReducer;
import com.tinkerpop.gremlin.process.graph.marker.Reversible;
import com.tinkerpop.gremlin.process.graph.marker.SideEffectCap;
import com.tinkerpop.gremlin.process.graph.step.filter.FilterStep;
import com.tinkerpop.gremlin.process.graph.step.sideEffect.SideEffectCapStep;
import com.tinkerpop.gremlin.process.util.TraversalHelper;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SideEffectCapComputerStep<S> extends FilterStep<S> implements Reversible, Bulkable, MapReducer, SideEffectCap {

    public final String variable;

    public SideEffectCapComputerStep(final Traversal traversal, final SideEffectCapStep sideEffectCapStep) {
        super(traversal);
        this.variable = sideEffectCapStep.sideEffectAs;
        this.setPredicate(traverser -> false);
    }

    public void setCurrentBulkCount(final long bulkCount) {
    }

    public MapReduce getMapReduce() {
        return new SideEffectCapMapReduce(this);
    }

    public String toString() {
        return TraversalHelper.makeStepString(this, this.variable);
    }

    public String getVariable() {
        return this.variable;
    }
}
