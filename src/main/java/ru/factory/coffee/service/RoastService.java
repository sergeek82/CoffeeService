package ru.factory.coffee.service;

import io.grpc.stub.StreamObserver;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.factory.coffee.grpc.RoastServiceGrpc;
import ru.factory.coffee.grpc.RoastServiceOuterClass.RoastRequest;
import ru.factory.coffee.grpc.RoastServiceOuterClass.RoastResponse;
import ru.factory.coffee.mapper.BrigadeMapper;
import ru.factory.coffee.model.CookBrigade;
import ru.factory.coffee.model.Store;
import ru.factory.coffee.repository.CoffeeStoreRepository;

@Component
@RequiredArgsConstructor
public class RoastService extends RoastServiceGrpc.RoastServiceImplBase {

  private final BrigadeMapper brigadeMapper;
  private final CoffeeStoreRepository repository;

  @Override
  @Transactional
  public void executeRoast(RoastRequest request,
      StreamObserver<RoastResponse> responseObserver) {

    CookBrigade brigade = brigadeMapper.toEntity(request);
    Long storeId = request.getStoreId();
    Store store = repository.findById(storeId).orElseThrow(
        () -> new EntityNotFoundException("Not found store with id : ".concat(storeId.toString())));
    store.setCookBrigade(brigade);
    Store saved = repository.save(store);
    Long id = saved.getCookBrigade().getId();

    RoastResponse roastResponse = RoastResponse.newBuilder().setCookBrigadeId(id).build();
    responseObserver.onNext(roastResponse);
    responseObserver.onCompleted();
  }
}
