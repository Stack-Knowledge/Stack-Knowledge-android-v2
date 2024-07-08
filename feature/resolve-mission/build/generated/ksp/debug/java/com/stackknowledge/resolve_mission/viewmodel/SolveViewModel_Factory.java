package com.stackknowledge.resolve_mission.viewmodel;

import com.stackknowledge.usecase.solve.SolveUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SolveViewModel_Factory implements Factory<SolveViewModel> {
  private final Provider<SolveUseCase> solveUseCaseProvider;

  public SolveViewModel_Factory(Provider<SolveUseCase> solveUseCaseProvider) {
    this.solveUseCaseProvider = solveUseCaseProvider;
  }

  @Override
  public SolveViewModel get() {
    return newInstance(solveUseCaseProvider.get());
  }

  public static SolveViewModel_Factory create(Provider<SolveUseCase> solveUseCaseProvider) {
    return new SolveViewModel_Factory(solveUseCaseProvider);
  }

  public static SolveViewModel newInstance(SolveUseCase solveUseCase) {
    return new SolveViewModel(solveUseCase);
  }
}
