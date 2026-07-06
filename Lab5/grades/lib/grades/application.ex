defmodule Grades.Application do
  @moduledoc false

  use Application

  def start(_type, _args) do
    children = [
      GradesWeb.Telemetry,
      {Phoenix.PubSub, name: Grades.PubSub},
      GradesWeb.Endpoint
    ]

    opts = [strategy: :one_for_one, name: Grades.Supervisor]
    Supervisor.start_link(children, opts)
  end

  def config_change(changed, _new, removed) do
    GradesWeb.Endpoint.config_change(changed, removed)
    :ok
  end
end